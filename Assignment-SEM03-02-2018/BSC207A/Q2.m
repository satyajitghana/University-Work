X = linspace(0, 10*pi/6, 6);
Y = [1.98 1.30 1.05 1.30 -0.88 -0.25];
[HS, a0, a, b] = harmonic_analysis(X, Y, 3);
HS = matlabFunction(HS);
fplot(HS, [0 x(end)], 'LineWidth', 2)
hold on;
plot(X, Y ,'*', 'LineWidth', 2)
grid on;
 
title('$ $ Harmonic Analysis', 'Interpreter', 'latex')
legend({'Harmonic Function', 'Data Points'}, 'Interpreter', 'latex')
xlabel('x $\rightarrow$', 'Interpreter', 'latex')
ylabel('f(x) $\rightarrow$', 'Interpreter', 'latex')
