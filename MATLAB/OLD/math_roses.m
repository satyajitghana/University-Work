k = 2;
figure
xt = @(t) cos(k*t).*cos(t);
yt = @(t) cos(k*t).*sin(t);
for k = -10:0.1:10
    pause(0.01);
    xt = @(t) cos(k*t).*cos(t);
    yt = @(t) cos(k*t).*sin(t);
    fplot(xt, yt, 'r-', 'LineWidth', 2);
    axis([-1 1 -1 1]);
    drawnow
end