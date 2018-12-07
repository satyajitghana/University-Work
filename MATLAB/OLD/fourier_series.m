function[] = fourier_series(f, K, T, precision)
    syms x;
    w = (2*pi)/T;
    n = 1:K;
    
    %% calculate the constants
    a0 = (2/T)*int(f, x, 0, 2*pi);
    an = (2/T)*int(f*cos(n*w*x), x, 0, 2*pi);
    bn = (2/T)*int(f*sin(n*w*x), x, 0, 2*pi);
    v1 = [a0, an, bn];
    v2 = [1/2 cos(n*w*x) sin(n*w*x)];
    
    FS = v1.*v2;
    
    %% fouriere transform
    FS = sum(FS);
    FS = vpa(FS);
    
    disp('Fourier Transformed Equation : ');
    disp(FS);
    
    %%x = linspace(0, T, 500);
    %%y = eval(FS);
    %%plot(x, y, 'r');
    fplot(sym(FS), [0 4*pi], 'LineWidth', 2);
    hold on;
    
    x = linspace(0, T, 500);
    y = f(x);
    ry = repmat(y, 1, 2);
    rx = linspace(0, 4*pi, length(ry));
    plot(rx, ry, 'LineWidth', 2);
end