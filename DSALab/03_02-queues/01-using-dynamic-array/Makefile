CC=gcc
CFLAGS=-I.
OUTPUT=queue

build: main.o vector.o queue.o input_helper.o
	$(CC) main.o vector.o queue.o input_helper.o -o $(OUTPUT)

main.o: main.c
	$(CC) -c main.c

timeutil.o: timeutil.c timeutil.h
	$(CC) -c timeutil.c

vector.o: vector.c vector.h
	$(CC) -c vector.c

stack.o: queue.c queue.h
	$(CC) -c queue.c

clean:
	rm *.o $(OUTPUT)
