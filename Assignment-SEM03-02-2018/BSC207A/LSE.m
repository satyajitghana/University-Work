function [error] = LSE(y_actual, y_estimated)
%LSE Computes the least square error between the actual and the estimated
%data points
% Author : Satyajit Ghana
%   uses sum(( y_actual - y_estimated)^2) the sum of square error
ya = y_actual;
ye = y_estimated;

error = sum((ya-ye).^2);

fprintf("Sum of Errors : %.12f\n", error);

end

