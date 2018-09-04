CC=gcc
CFLAGS=-I.
OUTPUT=string

build: main.o input_helper.o vector.o
	$(CC) main.o input_helper.o vector.o -o $(OUTPUT)

main.o: main.c
	$(CC) -c main.c

input_helper.o: input_helper.c input_helper.h
	$(CC) -c input_helper.c

vector.o: vector.c vector.h
	$(CC) -c vector.c

clean:
	rm *.o $(OUTPUT)
