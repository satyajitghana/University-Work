CC=gcc
CFLAGS=-I.
OUTPUT=infix2postfix

build: main.o vector.o input_helper.o stack.o
	$(CC) main.o vector.o input_helper.o stack.o -o $(OUTPUT)

main.o: main.c
	$(CC) -c main.c

vector.o: vector.c vector.h
	$(CC) -c vector.c

stack.o: stack.c stack.h
	$(CC) -c stack.c

clean:
	rm *.o $(OUTPUT)
