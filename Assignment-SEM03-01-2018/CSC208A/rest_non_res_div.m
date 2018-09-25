res_div = [-9 0 -8 1 -7 5 -4 5]
nonres_div = [-9 -8 -7 -4 5]
plot(1:1:length(res_div), res_div, '--*', 'LineWidth', 2);
hold on;
plot(1:1:length(nonres_div), nonres_div,'--*', 'LineWidth', 2);
grid on;
legend({'$ $Restoring Division', '$ $ Non-Restoring Division'},'Interpreter', 'latex', 'Location', 'best')
rt = cellstr(num2str(res_div'))
nrt = cellstr(num2str(nonres_div'))
dx = 0.9; dy = -0.5;
text(1:1:length(res_div)+dx, res_div + dy, rt, 'FontSize', 13);
text(1:1:length(nonres_div)+dx, nonres_div + dy, nrt, 'FontSize', 13);

title({'$ $ Restoring vs Non-Restoring Division for $\frac{5}{9}$'}, 'Interpreter', 'latex');