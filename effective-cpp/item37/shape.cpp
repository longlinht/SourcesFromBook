#include <iostream>
#include "shape.h"

/*
void Rectangle::draw(ShapeColor color) const {
    std::cout<<"Rectangle default color is: "<<color<<std::endl;
}

void Circle::draw(ShapeColor color) const {
    std::cout<<"Circle default color is: "<<color<<std::endl;
}
*/

void Shape::draw(ShapeColor color) const {
    doDraw(color);
}

void Rectangle::doDraw(ShapeColor color) const {
    std::cout<<"Rectangle default color is: "<<color<<std::endl;
}

void Circle::doDraw(ShapeColor color) const {
    std::cout<<"Circle default color is: "<<color<<std::endl;
}
