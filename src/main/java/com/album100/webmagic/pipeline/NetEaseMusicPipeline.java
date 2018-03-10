package com.album100.webmagic.pipeline;

import com.album100.webmagic.entity.Comment;
import com.album100.webmagic.entity.Music;
import com.album100.webmagic.repository.CommentRepository;
import com.album100.webmagic.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

@Component
public class NetEaseMusicPipeline implements Pipeline {

    @Autowired
    public MusicRepository musicDAO;

    @Autowired
    public CommentRepository commentDAO;

    @Override
    public void process(ResultItems resultItems, Task task) {

        for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
            if (entry.getKey().equals("music")) {
                Music music = (Music)entry.getValue();
                System.out.println("musicDAO--->null" + musicDAO == null);
                if (musicDAO.countBySongId(music.getSongId()) == 0) {
                    musicDAO.save(music);
                }
            } else {
                Comment comment = (Comment)entry.getValue();
                System.out.println("commentDAO--->null" + commentDAO == null);
                if (commentDAO.countByCommentId(comment.getCommentId()) == 0) {
                    commentDAO.save(comment);
                }
            }
        }

    }
}
