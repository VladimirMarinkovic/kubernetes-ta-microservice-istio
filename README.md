# kubernetes-travel-agency-microservice-istio

This project is based on project https://github.com/VladimirMarinkovic/travel-agency-microservice and configured for kubernetes deployment with Istio service mesh integration.

 **Install Istio on kubernetes cluster** - https://istio.io/docs/setup/install/
 
* **MySql deployment** - kubectl apply -f deployment-mysql-auth.yaml
* **Create Secret** - kubectl create secret generic auth-service --from-literal=RDS_PASSWORD=vladatravelagencyauth
* **Create Configmap** -  kubectl create configmap auth-service --from-literal=RDS_DB_NAME=travelagencyauth --from-     literal=RDS_HOSTNAME=mysql  --from-literal=RDS_PORT="3306" --from-literal=RDS_USERNAME=travelagencyauth-user

* **Auth Service deployment** - kubectl apply -f deployment-auth.yaml

* **Tura, Putnici, Vozaci Server deployment** - kubectl apply -f deployment-tura.yaml,deployment-putnici.yaml,deployment-vozaci.yaml 

* **Getway deployment** - kubectl apply -f http-gateway.yaml

* **Virtualservices deployment** - kubectl apply -f virtualservices.yaml



# Observing service mesh with Kiali

* **Create secret** - kubectl create secret generic kiali -n istio-system --from-literal=username=admin --from-literal=passphrase=admin
* **Port forward** - istioctl dashboard kiali   **OR**    kubectl -n istio-system  port-forward svc/kiali 20001
* **Access Kiali** - http://localhost:20001

1. Kiali Dashboard
![Kiali](https://github.com/VladimirMarinkovic/kubernetes-ta-microservice-istio/blob/master/tura-resource-server/src/main/resources/images/istio-3.jpg)



# Distributed tracing with Jaeger

* **Port forward** - istioctl dashboard jaeger
* **Access Jaeger** - http://localhost:16686

2. Jaeger Dashboard
![Jaeger](https://github.com/VladimirMarinkovic/kubernetes-ta-microservice-istio/blob/master/tura-resource-server/src/main/resources/images/jaeger.jpg)


# Postman Testing
3. Tour Content Result
![Postman](https://github.com/VladimirMarinkovic/kubernetes-ta-microservice-istio/blob/master/tura-resource-server/src/main/resources/images/result.jpg)

