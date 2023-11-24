# ApiRateLimiter_Core_Java
Thread safe implementaion of ratelimter using core java and singleton design pattern


Atlassian Problem Statement:


Problem Title: Rate Limiter
Problem Description:
Imagine we are building an application that is used by many different customers. We want to avoid one customer being able to overload the system by sending too many requests, so we enforce a per-customer rate limit. The rate limit is defined as:
“Each customer can make X requests per Y seconds”

// Perform rate limiting logic for provided customer ID. Return true if the
// request is allowed, and false if it is not.![image](https://github.com/shubhamharitash/ApiRateLimiter_Core_Java/assets/47567303/29582ffe-67f7-4d52-8bfa-dd2b7e0def93)
