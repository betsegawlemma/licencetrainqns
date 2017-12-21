package com.betsegaw.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Embeddable
public class Choice {

    @Enumerated(value = EnumType.STRING)
    Letter letter;
    String choiceDescription;

    @Lob
    private Byte[] choiceImage;

    public Choice() {
    }

    public Choice(Letter letter, String choiceDescription, Byte[] image) {
        this.letter = letter;
        this.choiceDescription = choiceDescription;
        this.choiceImage = image;
    }
}
