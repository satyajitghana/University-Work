.data
	msg: .asciiz "Hello World\n"
	num1: .word 5
	num2: .word 10

.text
	li 	$v0, 4 			# to print a string
	la 	$a0, msg
	syscall
	
	lw 	$t0, num1($zero)
	lw 	$t1, num2($zero)
	
	add 	$t3, $t0, $t1 		# t1 = t0 + t1
	li 	$v0, 1 			# load immediate to print a integer
	move 	$a0, $t3
	syscall
	