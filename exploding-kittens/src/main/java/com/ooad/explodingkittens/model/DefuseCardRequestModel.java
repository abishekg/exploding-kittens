package com.ooad.explodingkittens.model;

import com.ooad.explodingkittens.model.Card.Card;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
public class DefuseCardRequestModel {
    Card card;
    int idx;
}
