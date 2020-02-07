package com.lrm.blog.service;

import com.lrm.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TagService {

    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    void deleteTag(Long id);

    Tag updateTag(Long id, Tag tag);

    Tag getTagByName(String name);

    Page<Tag> listTag(Pageable pageable);
}
