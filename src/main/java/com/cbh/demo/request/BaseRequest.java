package com.cbh.demo.request;

import com.rop.RopRequest;
import com.rop.RopRequestContext;

/**
 * @Author: wb.caobaohe
 * @Date: 2018/10/18
 * @Description:
 */
public class BaseRequest implements RopRequest {

    @Override
    public RopRequestContext getRopRequestContext() {
        return null;
    }
}
