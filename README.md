# meal-scheduler

This is a test project - a Spring service managing meals schedule.

## Metrics delivery/browsing/storage framework set up

In order to prepare the application environment for metrics handling, the following needs to be done:

1. Prometheus:
    1. Download prometheus from: https://prometheus.io/download/
    2. Unzip the package contents to a directory
    3. Overwrite prometheus.yml from the package with the one from this PR
    4. Start prometheus calling 'prometheus.exe', it does not start automatically.
2. Grafana: 
    1. Download Grafana from https://grafana.com/grafana/downloadand 
    2. Install grafana
    3. Log in to grafana, running by default at 'http://localhost:3000' using 'admin'/'admin'
    4. Add a local Prometheus source, pointing to http://localhost:9090
    5. Add a new dashboard with 'GetAllMeals_seconds_max' and 'CreateMeal_seconds_max' metrics

  
