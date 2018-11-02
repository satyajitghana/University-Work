%%
X = linspace(0, 10*pi/6, 6);
Y = [1.98 1.30 1.05 1.30 -0.88 -0.25];
for i=1:1:2
    [HS, a0, a, b] = harmonic_analysis(X, Y, i);
    disp("Harmonic Function for " + num2str(i) + " harmonics");
    disp(vpa(HS, 4));
    disp('Coefficients : ')
    disp(a0);
    disp(a);
    disp(b);
end
%%
X = linspace(0, 10*pi/6, 6);
Y = [1.98 1.30 1.05 1.30 -0.88 -0.25];
[HS, a0, a, b] = harmonic_analysis(X, Y, 3);
HS = matlabFunction(HS);
%LSE(Y, HS(X));
sum((Y-HS(X)).^2)
%%
% a=4;n=8;
% x=linspace(-a,a,n);
% y=linspace(-a,a,n);
% z=linspace(-a,a,n);
[x,y,z]=meshgrid(-4:1:4);
f1=y.^3.*sin(x)+z.^5;
f2=3.*y.^2.*cos(x)-7.*exp(7.*y).*z;
f3=5.*x.*z.^4+exp(7.*y);
figure
quiver3(x,y,z,f1,f2,f3);
grid on
hold on
surf(x,y,z)
view(-35,45)
axis([-2 2 -1 1 -.6 .6])
hold off

%% quiver plot
[x, y, z] = meshgrid(-4:1:4);
u = (y.^3).*sin(x)+z.^5;
v = 3.*(y.^2).*cos(x)-7.*exp(7.*y).*z;
w = 5.*x.*(z.^4)+exp(7.*y);

quiver3(x, y, z, u, v, w);

%% cone plot
clf;
clear all;

[x, y, z] = meshgrid(-4:1:4);
u = y.^3.*sin(x)+z.^5;
v = -3.*y.^2.*cos(x)+7.*exp(7.*y).*z;
w = 5.*x.*z.^4+exp(7.*y);

[cx, cy, cz] = meshgrid(-4:0.4);
h = coneplot(x, y, z, u, v, w, cx, cy, cz, 5);
set(h, 'FaceColor', 'r', 'EdgeColor', 'none');
camlight; lighting gouraud;

grid on; box on;
axis([-4 4 -4 4 -4 4]);
view(-30, 60);

%% streamline plot
clf;
clear all;

[x, y, z] = meshgrid(-4:1:4);
u = y.^3.*sin(x)+z.^5;
v = 3.*y.^2.*cos(x)-7.*exp(7.*y).*z;
w = 5.*x.*z.^4+exp(7.*y);

[sx,sy,sz] = meshgrid(-1.5, -1:1, -1:1);
hhh = streamline(x, y, z, u, v, w, -1, 1, -1.5);
hold on;
plot3(sx(:), sy(:), sz(:), 'bo', 'MarkerFaceColor', 'b')
grid on; box on;
view(-30, 60);

%% stream slice
clf;
clear all;

[x, y, z] = meshgrid(-4:1:4);
u = y.^3.*sin(x)+z.^5;
v = 3.*y.^2.*cos(x)-7.*exp(7.*y).*z;
w = 5.*x.*z.^4+exp(7.*y);

streamslice(x, y, z, u, v, w, 4, 4, -4);
box on;
axis([-4 4 -4 4 -4 4]);
view(-30, 60);

%% stream tubes
clf;
clear all;

[x, y, z] = meshgrid(-4:1:4);
u = y.^3.*sin(x)+z.^5;
v = 3.*y.^2.*cos(x)-7.*exp(7.*y).*z;
w = 5.*x.*z.^4+exp(7.*y);

[sx, sy, sz] = meshgrid(-4, -2:2, -2:2);  % stream starting point

% streamtube
subplot(121);
streamtube(x, y, z, u, v, w, sx, sy, sz);
shading interp
axis([-4 4 -4 4 -4 4]);
camlight; lighting gouraud
grid on;
title('streamtube');

% streamribbon
subplot(122);
streamribbon(x, y, z, u, v, w, sx, sy, sz);
shading interp
axis([-4 4 -4 4 -4 4]);
camlight headlight; camlight right; lighting gouraud
grid on;
title('streamribbon');
