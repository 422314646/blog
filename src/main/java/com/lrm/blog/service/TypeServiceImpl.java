package com.lrm.blog.service;


import com.lrm.blog.NotFoundException;
import com.lrm.blog.dao.TypeRepository;
import com.lrm.blog.po.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by limi on 2017/10/16.
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }


    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findOne(id);
        if (t == null) {
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);
        return typeRepository.save(t);
    }



    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.delete(id);
    }
}
