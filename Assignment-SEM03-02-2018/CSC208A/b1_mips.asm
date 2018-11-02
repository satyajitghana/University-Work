# Sum of N natural numbers

.data
	n: .word 100

.text
	main:
		lw	$t0, n($zero)
		li	$t1, 0
		
		loop:
			beq	$t0, $zero, disp
			add	$t1, $t1, $t0
			subi	$t0, $t0, 1
			j loop
		
		# syscall to end the program
		li	$v0, 10
		syscall
	
	disp:
		li	$v0, 1
		move	$a0, $t1
		syscall
