CC=gcc
CFLAGS=-I.
OUTPUT=pointers

build: main.o vector.o input_helper.o
	$(CC) main.o vector.o input_helper.o -o $(OUTPUT)

main.o: main.c
	$(CC) -c main.c

vector.o: vector.c vector.h
	$(CC) -c vector.c

clean:
	rm *.o $(OUTPUT)
