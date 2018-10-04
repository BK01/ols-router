# BC Route Planner NG
BC Route Planner NG is a three year project of the Province of British Columbia to develop a state-of-the art route planner. The BC Route Planner NG is a vital component of the free and open DataBC Location Services Platform.

In year 1 (2018-19), we will investigate the feasibility of supporting multiple complex routing constraints including support time-dependent routing including historic traffic congestion, road incidents and closures, road construction, and ferry schedules. The first release will include those components for which there is insufficient or no real data so that developers can start integrating the route planner into their new applications as soon as possible. Tackling data issues is beyond the scope of this project and their resolution may be many months away. The performance goal of the first release is under two seconds for a single, two-point, oversized truck route.

In year 2 (2019-2020), we will add support for truck routing, a road watcher, and new data sources. Truck routing takes vehicle dimensions and road restrictions into account.

In Year 3 (2020-2021), we will focus on incorporating user-requested enhancements, making routes more realistic, and improving performance.

[Current milestones for this year](https://github.com/bcgov/ols-router/milestones)

[Draft year 1 Route Planner release notes](https://github.com/bcgov/ols-router/issues/75)

[Draft Integrated Transportation Network Data Model Gaps](https://github.com/bcgov/ols-router/blob/master/ITN-Data-Mode-Gaps.md)

## Draft System Architecture
The BC Route Planner NG is a web service (aka API) running behind Kong, our API Gateway. Kong is an NGINX plugin that provides security and access control, metering, and load balancing. Multiple route planner nodes will be deployed across multiple data centres to ensure service is not interrupted during scheduled maintenance or data centre failure.

Phase 2 Architecture
On startup, the Road Watcher will read in the latest static road network into a cached, live road network. The Road Watcher will then update the live road network from real-time APIs on a periodic schedule (e.g., every five minutes). The Road Watcher will be restarted on a schedule that keeps up with road network change (e.g., every week).

![](https://github.com/bcgov/ols-router/blob/master/BC%20Route%20Planner%20NG%20Architecture.png)
