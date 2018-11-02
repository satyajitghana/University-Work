syms n;
sn = 1767.979236*0.6019165917^n - 1739.979186*0.6053581886^n + 15.99994951*(-0.9210509025)^n;
x = 0:1:50;
y = subs(sn, x);
plot(x, y);
hold on;
grid on;
legend({'$S_n$'}, 'Interpreter', 'latex');
title("$ $ Recurrence Function Plot", 'Interpreter', 'latex');
xlabel("Time (hours) $\rightarrow$", 'Interpreter', 'latex');
ylabel("Amount of data transferred $\rightarrow$", 'Interpreter', 'latex');

disp('Amount of Data Transferred at the 50th Hour');
disp(vpa(subs(sn, 50), 30))
disp('Total Amount of Data Transferred from 0th to 50th Hour');
sum = 0;
for i=0:50
    sum = sum + subs(sn, i);
end
disp(vpa(sum, 30))