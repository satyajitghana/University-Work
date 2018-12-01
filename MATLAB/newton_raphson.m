function [root] = newton_raphson(func, diff, x0, maxiter, xmin, xmax)
%UNTITLED3 Summary of this function goes here
%   Detailed explanation goes here

x = x0;
root = nan;
tol = 10^(-10);
for i = 1:maxiter
    if diff(x(i)) < tol
        fprintf('Pitfall has occured try a btter initial guess\n');
        return;
    end
    x(i+1) = x(i) - func(x(i))/diff(x(i));
    abs_error(i+1) = abs((x(i+1)-x(i))/x(i+1))*100;
    if abs(x(i+1) - x(i)) < tol
        fprintf('The root has converged at x = %.10f\n', x(i+1));
        root = x(i+1);
        fplot(func, [xmin xmax]);
        hold on;
        title('$ $ Newton-Raphson method to find root of f(x)', 'Interpreter', 'latex');
        plot(root, 0, '*');
        text(root, 0, '\leftarrow root');
        legend(func2str(func));
        grid on;
        break;
    else
        fprintf('Iteration no: %d, current guess x = %.10f, error = %.5f\n', i, x(i+1), abs_error(i+1));
    end
end
end

