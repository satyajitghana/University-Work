function[] = my_fourier(K, T)
    syms x;
    w = (2*pi)/T;
    n = 1:K;
    f = x^2;
    a0 = (2/T)*int(f, x, 0, 2*pi);
    an = (2/T)*int(f*cos(n*w*x), x, 0, 2*pi);
    bn = (2/T)*int(f*sin(n*w*x), x, 0, 2*pi);
    v1 = [a0, an, bn];
    v2 = [1/2 cos(n*w*x) sin(n*w*x)];
    FS = v1*v2';
    FS = vpa(FS);
    x = linspace(0, 4*pi, 500);
    y = eval(FS);
    plot(x, y, 'r');
    hold on;
    
    g = @(x) x.^2;
    x1 = linspace(0, 2*pi, 500);
    y1 = g(x1);
    ry1 = repmat(y1, 1, 2);
    rx1 = linspace(0, 4*pi, length(ry1));
    plot(rx1, ry1, 'b');
end