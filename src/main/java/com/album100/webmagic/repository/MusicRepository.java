package com.album100.webmagic.repository;

import com.album100.webmagic.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

    int countBySongId(String songId);
}
