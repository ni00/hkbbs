package site.zhangerfa.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import site.zhangerfa.controller.tool.Code;
import site.zhangerfa.controller.tool.Result;
import site.zhangerfa.pojo.*;
import site.zhangerfa.service.CardService;
import site.zhangerfa.service.CommentService;
import site.zhangerfa.service.UserService;
import site.zhangerfa.util.CardUtil;
import site.zhangerfa.util.Constant;
import site.zhangerfa.util.HostHolder;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/cards")
public class CardController {
    @Resource
    private CardService cardService;

    @Resource
    private UserService userService;

    @Resource
    private HostHolder hostHolder;

    @Resource
    private CardUtil cardUtil;

    @Resource
    private CommentService commentService;

    @GetMapping
    @ResponseBody
    public Result getOnePageCards(Page page){
        List<Card> cards = cardService.getOnePageCards("0", page.getOffset(),
                page.getLimit());
        List<Map> res;
        Integer code;
        if (cards == null){
            res = null;
            code = Code.GET_ERR;
        }else {
            res = cardUtil.completeCard(cards);
            code = Code.GET_OK;
        }
        return new Result(code, res);
    }

    @GetMapping("/my")
    @ResponseBody
    public Result getOnePageCardsByStuId(Page page,
                                         @CookieValue("ticket") String ticket){
        String stuId = userService.getStuIdByTicket(ticket);
        List<Card> cards = cardService.getOnePageCards(stuId,
                page.getOffset(), page.getLimit());
        Integer code = cards != null? Code.GET_OK: Code.GET_ERR;
        return new Result(code, cards);
    }

    // 新增一个卡片
    @PostMapping
    @ResponseBody
    public Result addCard(@RequestBody Card card){
        String stuId = hostHolder.getUser().getStuId();
        card.setPosterId(stuId);
        boolean flag = cardService.add(card);
        return new Result(flag? Code.SAVE_OK: Code.SAVE_ERR, flag);
    }

    /**
     * 返回帖子详情界面
     * @param cardId
     * @return
     */
    @GetMapping("/details/{cardId}")
    public String getDetails(@PathVariable int cardId, Model model, Page page){
        // 查帖子
        Card card = cardService.getCardById(cardId);
        model.addAttribute("card", card);
        // 查作者信息
        User user = hostHolder.getUser();
        model.addAttribute("user", user);
        // 查分页信息
        page.setRows(card.getCommentNum());
        page.setPath("/details/" + cardId);
        // 查询所有回帖
        List<Comment> comments = commentService.getCommentsForEntity(Constant.ENTITY_TYPE_CARD, cardId,
                page.getOffset(), page.getLimit());
        // comments是一个list，每个值是一个map
        // 每个map包含，content、username、comment4comment
        //      comment是回复该回复的回复，是一个list，每个值为map
        //      每个map包含，content、username、target、numOfComment
        //          其中，target是发出被回复对象的用户信息
        model.addAttribute("comments", cardUtil.completeComment(comments));

        return "site/card-detail";
    }
}
