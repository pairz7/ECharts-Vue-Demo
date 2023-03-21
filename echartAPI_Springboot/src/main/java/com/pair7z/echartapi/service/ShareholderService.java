package com.pair7z.echartapi.service;

import com.pair7z.echartapi.entity.Response;
import com.pair7z.echartapi.entity.Shareholder;

import java.util.List;

public interface ShareholderService {
    int addShareholder(Shareholder shareholder);
    List<Shareholder> queryAllShareholders();
    int modifyShare(String name,Integer newValue);
    int delShareholderByName(String name);
    Shareholder queryShareholderByName(String name);
}
