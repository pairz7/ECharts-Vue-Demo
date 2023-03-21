package com.pair7z.echartapi.service.impl;

import com.pair7z.echartapi.entity.Shareholder;
import com.pair7z.echartapi.mapper.ShareholderMapper;
import com.pair7z.echartapi.service.ShareholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareholderServiceImpl implements ShareholderService {
    @Autowired
    ShareholderMapper shareholderMapper;
    @Override
    public int addShareholder(Shareholder shareholder) {
        return shareholderMapper.addShareholder(shareholder);
    }

    @Override
    public List<Shareholder> queryAllShareholders() {
        return shareholderMapper.queryAllShareholders();
    }

    @Override
    public int modifyShare(String name, Integer newValue) {
        return shareholderMapper.modifyShare(new Shareholder(name,newValue));
    }

    @Override
    public int delShareholderByName(String name) {
        return shareholderMapper.delShareholderByName(name);
    }

    @Override
    public Shareholder queryShareholderByName(String name) {
        return shareholderMapper.queryShareholderByName(name);
    }
}
