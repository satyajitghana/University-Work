CC=gcc
CFLAGS=-I.
DEPS = timeutil.h
OBJ = main.o timeutil.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

random: $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS)

clean:
	rm *.o random
