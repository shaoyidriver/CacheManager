package cn.sy.amqp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Oranger implements Serializable {
    private Integer orgId;
    private String name;
    private String news;
}
