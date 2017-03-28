objects = main.o shape.o
cppsnippets : $(objects)
	g++ -o cppsnippets $(objects)
main.o : shape.h
shape.o : shape.h
.PHONY : clean
clean :
	rm cppsnippets $(objects)
