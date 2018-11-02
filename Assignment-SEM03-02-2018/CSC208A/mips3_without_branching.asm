.text
	li	$t0, 2
	li	$t1, 0

	add	$t1, $t1, $t0
	sub	$t0, $t0, 1
		
	li	$v0, 10
	syscall		
	