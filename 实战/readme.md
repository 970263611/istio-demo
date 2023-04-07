0.拥有k8s和istio环境

1.将两个服务打包制作成镜像为demomvc:v1，demoservice:v1

2.创建命名空间：

```
kubectl create namespace istio0322
```

3.自动注入边车指令

```
kubectl label namespace istio0322 istio-injection=enabled
```

4.调整istio监听网格外流量

```
kubectl get svc mvc-k8s-svc -nistio0322 -o yaml
```

添加需要的端口

```
- name: http-share
  nodePort: 30001
  port: 10001
  protocol: TCP
  targetPort: 2000
```

5.执行启动

```
kubectl apply -R -f *.yaml
```

6.请求测试(反复请求看效果)

```
curl localhost:30001?color=white
```

```
curl localhost:30001?color=red
```

```
curl localhost:30001?color=yellow
```

```
curl localhost:30001?color=blue
```

