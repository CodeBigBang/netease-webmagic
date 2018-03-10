package com.album100.webmagic.service;

import com.album100.webmagic.entity.Comment;
import com.album100.webmagic.entity.Music;
import com.album100.webmagic.repository.CommentRepository;
import com.album100.webmagic.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    private CommentRepository mCommentRepository;

    @Autowired
    private MusicRepository mMusicRepository;

    public void addMusic(Music music) {
        //判断数据是否存在
        if (mMusicRepository.countBySongId(music.getSongId()) == 0) {
            mMusicRepository.save(music);
        }
    }

    public void addComment(Comment comment) {
        //判断数据是否存在
        if (mCommentRepository.countByCommentId(comment.getCommentId()) == 0) {
            mCommentRepository.save(comment);
        }
    }

    public void addComments(List<Comment> comments) {
        mCommentRepository.save(comments);
    }

}
