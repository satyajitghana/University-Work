CC=gcc
CFLAGS=-I.
OUTPUT=vector

build: main.o vector.o input_helper.o
	$(CC) main.o vector.o input_helper.o -o $(OUTPUT)

main.o: main.c
	$(CC) -c main.c

timeutil.o: timeutil.c timeutil.h
	$(CC) -c timeutil.c

vector.o: vector.c vector.h
	$(CC) -c vector.c

clean:
	rm *.o $(OUTPUT)
