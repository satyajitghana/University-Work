s = [34 -25.566 17.4603 -28.631 10.4935 -26.486]

A = [s(3) s(2) s(1);
     s(4) s(3) s(2);
     s(5) s(4) s(3)]
 
B = [s(4);
     s(5);
     s(6)]
 
C = A\B

rts = roots([1 -C(1) -C(2) -C(3)])'
rho = sqrt(real(rts(2))^2 + imag(rts(2))^2 )
theta = atan(abs(imag(rts(2))/real(rts(2))))
syms n
rs = [(rho^n) * cos(n*theta) (rho^n) * sin(n*theta) rts(1)^n];
rs = vpa(rs, 20)
rsNew = [subs(rs, 0); subs(rs, 1); subs(rs, 2)];
rsNew = vpa(rsNew, 20)
Sc = [s(1); s(2); s(3)]
B = vpa(rsNew \ Sc, 20)
syms n
Sn = B(1)*(rho^n)*cos(n*theta) + B(2)*(rho^n)* sin(n*theta) + B(3)*(rts(1)^n);
vpa(Sn, 20)
vpa(subs(Sn, [0 1 2 3 4 5]), 20)
s