package com.app.user.dto;

import lombok.Data;
import org.joda.time.DateTime;

@Data
public class GeyserUpdate {
    public String message;
    public String status;
    public DateTime createdAt;
}
