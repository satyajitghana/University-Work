syms t
w = sqrt(39)/8;
a1 = -27*cos(2*t)+4*sin(2*t);
a2 = cos(w*t);
a3 = sin(w*t);
a4 = exp(-t/8);

y1 = (1/149)*(a1+27*a4*a2-(37/sqrt(39))*a4*a3);
y2 = (1/149)*(a1+27*a4*a2+(5923/sqrt(39))*a4*a3);

fplot(y1, [0 5], 'LineWidth', 2);
hold on;
fplot(y2, [0 5], 'LineWidth', 2);
grid on;

legend('Sol 1', 'Sol 2');