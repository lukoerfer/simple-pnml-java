package de.lukaskoerfer.simplepnml;

import static org.junit.jupiter.api.Assertions.*;

class LineTest {

    void canCreateLine() {
        Line line = new Line();
        line.setColor("red");
        line.setShape(LineShape.CURVE);
        line.setStyle(LineStyle.DOT);
        line.setWidth(4.5);
    }

    void canCreateLineFluently() {
        Line line = Line.builder()
            .color("red")
            .shape(LineShape.LINE)
            .style(LineStyle.SOLID)
            .width(3.5)
            .build();
    }

}
