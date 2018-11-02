X = linspace(-4, 4, 10); Y = linspace(-4, 4, 10); Z = linspace(-4, 4, 10);
[x, y, z] = meshgrid(X, Y, Z);

u = y.^3.*sin(x)+z.^5;
v = -3.*y.^2.*cos(x)+7.*exp(7.*y).*z;
w = 5.*x.*z.^4+exp(7.*y);

%% Quiver Plot

quiver3(x, y, z, u, v, w, 'LineWidth', 1);
hold on;
grid on;
box on;
title('Quiver Plot', 'Interpreter', 'latex')

%% Stream Slice

streamslice(x, y, z, u, v, w, 4, 4, -4);
grid on;
hold on;
box on;
axis([-4 4 -4 4 -4 4]);
view(-50, 30);
title('Stream Slice', 'Interpreter', 'latex')

%% Cone Plot

[cx, cy, cz] = meshgrid([-1 0 1]);

coneplot(x, y, z, u, v, w, cx, cy, cz);
hold on;
grid on;
box on;
title('Cone Plot', 'Interpreter', 'latex')