package com.pair7z.echartapi.mapper;

import com.pair7z.echartapi.entity.Response;
import com.pair7z.echartapi.entity.Shareholder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ShareholderMapper {
    int addShareholder(Shareholder shareholder);
    List<Shareholder> queryAllShareholders();
    int modifyShare(Shareholder shareholder);
    int delShareholderByName(String name);
    Shareholder queryShareholderByName(String name);
}
