# Program : perform 2*x+y if x != y, else exit
# equivalent C program:
# int main() {
# 	int x = 2;
# 	int y = 1;
# 	if (x != y) return 0;
#	int res = 2 * x + y;
#	return res;
# }

.text
	main:
		li	$t0, 2
		li	$t1, 1

		beq	$t0, $t1, exit
		mul	$t3, $t0, 2
		add	$t3, $t3, $t1
	
	exit:
		li	$v0, 10
		syscall
