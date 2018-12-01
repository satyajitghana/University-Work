%% Vector to plot
[x, y, z] = meshgrid(-4:1:4);
u = (y.^3).*sin(x)+z.^5;
v = 3.*(y.^2).*cos(x)-7.*exp(7.*y).*z;
w = 5.*x.*(z.^4)+exp(7.*y);

%% Quiver Plot
quiver3(x, y, z, u, v, w, 'LineWidth', 2);

%% Scatter plots
scatter3(u(:), v(:), w(:), 'EdgeColor', 'none')