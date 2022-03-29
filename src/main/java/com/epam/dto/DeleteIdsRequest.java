package com.epam.dto;

import java.util.List;

public class DeleteIdsRequest {
    List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
