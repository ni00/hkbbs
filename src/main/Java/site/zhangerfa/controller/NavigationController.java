package site.zhangerfa.controller;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import site.zhangerfa.pojo.Card;
import site.zhangerfa.pojo.Page;
import site.zhangerfa.service.CardService;
import site.zhangerfa.service.UserService;

import java.util.List;

/**
 * 导航栏跳转控制器
 */
@Controller
public class NavigationController {
    @Resource
    private CardService cardService;

    @Resource
    private UserService userService;

    /**
     * 跳转到我的主页
     */
    @RequestMapping("/my")
    public String my(@CookieValue("ticket") String ticket,
                     Page page, Model model){
        // page对象被自动注入到model对象中
        page.setRows(cardService.getNumOfCards());
        page.setPath("/my");

        // 通过登录凭证获取用户学号
        String stuId = userService.getStuIdByTicket(ticket);

        String username = userService.getUsernameByStuId(stuId);
        model.addAttribute("username", username);
        List<Card> cards = cardService.getOnePageCards(stuId,
                page.getOffset(), page.getLimit());// 获取一页卡片
        model.addAttribute("cards", cards);
        return "site/myWall";
    }

    /**
     * 访问卡片墙
     * @param ticket
     * @param model
     * @return
     */
    @GetMapping("/wall")
    public String wall(@CookieValue("ticket") String ticket,
                       Page page, Model model){
        page.setRows(cardService.getNumOfCards());
        page.setPath("/wall");

        String stuId = userService.getStuIdByTicket(ticket);
        String username = userService.getUsernameByStuId(stuId);
        model.addAttribute("username", username);
        List<Card> cards = cardService.getOnePageCards("0",
                page.getOffset(), page.getLimit());// 获取一页卡片
        model.addAttribute("cards", cards);
        return "site/wall";
    }

    /**
     * 访问树洞
     */
    @RequestMapping("/hole")
    public String hole(@CookieValue("ticket") String ticket,
                       Page page, Model model){
        return "site/hole";
    }

    /**
     * 访问域名时资源跳转
     * @return
     */
    @RequestMapping("/")
    public String homeRedirect(){
        return "forward:/wall";
    }

    /**
     * 跳转到卡片墙页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "site/login";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "site/register";
    }

}