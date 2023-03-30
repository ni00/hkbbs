package site.zhangerfa.service.impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import site.zhangerfa.pojo.Comment;
import site.zhangerfa.pojo.Post;
import site.zhangerfa.service.HoleNicknameService;

import java.util.Map;

/**
 * 树洞的帖子接口实现类
 */
@Service
public class HoleServiceImpl extends PostServiceImpl{
    @Resource
    private HoleNicknameService holeNicknameService;

    @Override
    @Transactional(isolation= Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public boolean add(Post hole, int postType) {
        boolean insert = super.add(hole, postType);
        // 为洞主生成随机昵称
        boolean flag = holeNicknameService.addHoleNickname(hole.getId(), hole.getPosterId());
        return insert && flag;
    }

    @Override
    @Transactional(isolation= Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public Map<String, Object> deleteById(int id) {
        super.deleteById(id);
        // 删除所有该树洞的随机昵称
        holeNicknameService.deleteNicknamesForHole(id);
        return super.deleteById(id);
    }

    @Override
    @Transactional(isolation= Isolation.READ_COMMITTED, propagation = Propagation.NESTED)
    public boolean addComment(Comment comment, int holeId) {
        boolean flag = super.addComment(comment, holeId);
        // 生成随机昵称
        flag &= holeNicknameService.addHoleNickname(holeId, comment.getPosterId());
        return flag;
    }
}