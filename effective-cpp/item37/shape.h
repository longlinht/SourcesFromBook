// a class for geometric shapes to demo

/*
 * Error-prone way
 *
class Shape {

    public:
        enum ShapeColor {Red, Green, Blue};
        // all shapes must offer a function to draw themselves
        virtual void draw(ShapeColor color = Red) const = 0;
};

class Rectangle : public Shape {
    // notice the different default parameter value — bad!
    virtual void draw(ShapeColor color = Green) const;
};

class Circle : public Shape {
    virtual void draw(ShapeColor color) const;
};
*/

/*
 * Better way
 */

class Shape {

    public:
        enum ShapeColor {Red, Green, Blue};
        // all shapes must offer a function to draw themselves
        void draw(ShapeColor color = Red) const;

        virtual void doDraw(ShapeColor color) const = 0;
};

class Rectangle : public Shape {
    virtual void doDraw(ShapeColor color) const;
};

class Circle : public Shape {
    virtual void doDraw(ShapeColor color) const;
};
