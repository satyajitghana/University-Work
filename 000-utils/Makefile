CC=gcc
CFLAGS=-I.
OUTPUT=random

build: main.o timeutil.o
	$(CC) main.o timeutil.o -o $(OUTPUT)

main.o: main.c
	$(CC) -c main.c

timeutil.o: timeutil.c timeutil.h
	$(CC) -c timeutil.c

clean:
	rm *.o $(OUTPUT)
