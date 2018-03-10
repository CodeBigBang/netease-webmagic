package com.album100.webmagic.repository;

import com.album100.webmagic.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    int countByCommentId(Integer commentId);

}
