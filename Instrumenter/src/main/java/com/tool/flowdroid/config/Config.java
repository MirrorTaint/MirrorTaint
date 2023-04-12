package com.tool.flowdroid.config;

import com.google.common.collect.Sets;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

public class Config {

    public static final String SEPARATOR = System.getProperty("path.separator");
    public static final String GENERATED_HELPER_SLASH_CLASS_NAME = "com/tool/agent/SourceAndSink";
    public static final String GENERATED_HELPER_CLASS_NAME = "SourceAndSink";
    public static final String GENERATED_HELPER_CLASS_RELATED_PATH = GENERATED_HELPER_SLASH_CLASS_NAME + ".class";

    public static Set<String> interfaceMethods = Sets.newHashSet(
            // test
            "MemoryOverheadTest##main##([Ljava/lang/String;)V",

            // sock shop
            "works/weave/socks/cart/controllers/CartsController##get##(Ljava/lang/String;)Lworks/weave/socks/cart/entities/Cart;",
            "works/weave/socks/cart/controllers/CartsController##delete##(Ljava/lang/String;)V",
            "works/weave/socks/cart/controllers/CartsController##mergeCarts##(Ljava/lang/String;Ljava/lang/String;)V",
            "works/weave/socks/cart/controllers/ItemsController##get##(Ljava/lang/String;Ljava/lang/String;)Lworks/weave/socks/cart/entities/Item;",
            "works/weave/socks/cart/controllers/ItemsController##getItems##(Ljava/lang/String;)Ljava/util/List;",
            "works/weave/socks/cart/controllers/ItemsController##addToCart##(Ljava/lang/String;Lworks/weave/socks/cart/entities/Item;)Lworks/weave/socks/cart/entities/Item;",
            "works/weave/socks/cart/controllers/ItemsController##removeItem##(Ljava/lang/String;Ljava/lang/String;)V",
            "works/weave/socks/cart/controllers/ItemsController##updateItem##(Ljava/lang/String;Lworks/weave/socks/cart/entities/Item;)V",
            "works/weave/socks/shipping/controllers/ShippingController##getShipping##()Ljava/lang/String;",
            "works/weave/socks/shipping/controllers/ShippingController##getShippingById##(Ljava/lang/String;)Ljava/lang/String;",
            "works/weave/socks/shipping/controllers/ShippingController##postShipping##(Lworks/weave/socks/shipping/entities/Shipment;)Lworks/weave/socks/shipping/entities/Shipment;",
            "works/weave/socks/orders/controllers/OrdersController##newOrder##(Lworks/weave/socks/orders/resources/NewOrderResource;)Lworks/weave/socks/orders/entities/CustomerOrder;",

            // apollo
            "com/ctrip/framework/apollo/adminservice/controller/AccessKeyController##create##(Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/AccessKeyDTO;)Lcom/ctrip/framework/apollo/common/dto/AccessKeyDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/AccessKeyController##delete##(Ljava/lang/String;JLjava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/AccessKeyController##disable##(Ljava/lang/String;JLjava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/AccessKeyController##enable##(Ljava/lang/String;JLjava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/AccessKeyController##findByAppId##(Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/AppController##create##(Lcom/ctrip/framework/apollo/common/dto/AppDTO;)Lcom/ctrip/framework/apollo/common/dto/AppDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/AppController##delete##(Ljava/lang/String;Ljava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/AppController##find##(Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/AppController##get##(Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/AppDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/AppController##isAppIdUnique##(Ljava/lang/String;)Z",
            "com/ctrip/framework/apollo/adminservice/controller/AppController##update##(Ljava/lang/String;Lcom/ctrip/framework/apollo/common/entity/App;)V",
            "com/ctrip/framework/apollo/adminservice/controller/AppNamespaceController##countPublicAppNamespaceAssociatedNamespaces##(Ljava/lang/String;)I",
            "com/ctrip/framework/apollo/adminservice/controller/AppNamespaceController##create##(Lcom/ctrip/framework/apollo/common/dto/AppNamespaceDTO;Z)Lcom/ctrip/framework/apollo/common/dto/AppNamespaceDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/AppNamespaceController##delete##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/AppNamespaceController##findPublicAppNamespaceAllNamespaces##(Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/AppNamespaceController##getAppNamespaces##(Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/ClusterController##create##(Ljava/lang/String;ZLcom/ctrip/framework/apollo/common/dto/ClusterDTO;)Lcom/ctrip/framework/apollo/common/dto/ClusterDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ClusterController##delete##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/ClusterController##find##(Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/ClusterController##get##(Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/ClusterDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ClusterController##isAppIdUnique##(Ljava/lang/String;Ljava/lang/String;)Z",
            "com/ctrip/framework/apollo/adminservice/controller/CommitController##find##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/IndexController##index##()Ljava/lang/String;",
            "com/ctrip/framework/apollo/adminservice/controller/InstanceConfigController##getByRelease##(JLorg/springframework/data/domain/Pageable;)Lcom/ctrip/framework/apollo/common/dto/PageDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/InstanceConfigController##getByReleasesNotIn##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/InstanceConfigController##getInstancesByNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Lcom/ctrip/framework/apollo/common/dto/PageDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/InstanceConfigController##getInstancesCountByNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J",
            "com/ctrip/framework/apollo/adminservice/controller/ItemController##create##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/ItemDTO;)Lcom/ctrip/framework/apollo/common/dto/ItemDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ItemController##delete##(JLjava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/ItemController##findDeletedItems##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/ItemController##findItems##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/ItemController##get##(J)Lcom/ctrip/framework/apollo/common/dto/ItemDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ItemController##get##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/ItemDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ItemController##update##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLcom/ctrip/framework/apollo/common/dto/ItemDTO;)Lcom/ctrip/framework/apollo/common/dto/ItemDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ItemSetController##create##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/ItemChangeSets;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceBranchController##createBranch##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/NamespaceDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceBranchController##deleteBranch##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceBranchController##findBranchGrayRules##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/GrayReleaseRuleDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceBranchController##loadNamespaceBranch##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/NamespaceDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceBranchController##updateBranchGrayRules##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/GrayReleaseRuleDTO;)V",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceController##create##(Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/NamespaceDTO;)Lcom/ctrip/framework/apollo/common/dto/NamespaceDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceController##delete##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceController##find##(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceController##findPublicNamespaceForAssociatedNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/NamespaceDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceController##get##(Ljava/lang/Long;)Lcom/ctrip/framework/apollo/common/dto/NamespaceDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceController##get##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/NamespaceDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceController##namespacePublishInfo##(Ljava/lang/String;)Ljava/util/Map;",
            "com/ctrip/framework/apollo/adminservice/controller/NamespaceLockController##getNamespaceLockOwner##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/NamespaceLockDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseController##findActiveReleases##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseController##findAllReleases##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseController##findReleaseByIds##(Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseController##get##(J)Lcom/ctrip/framework/apollo/common/dto/ReleaseDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseController##getLatest##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/ReleaseDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseController##publish##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/ctrip/framework/apollo/common/dto/ReleaseDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseController##publish##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Set;)Lcom/ctrip/framework/apollo/common/dto/ReleaseDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseController##rollback##(JJLjava/lang/String;)V",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseController##updateAndPublish##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLcom/ctrip/framework/apollo/common/dto/ItemChangeSets;)Lcom/ctrip/framework/apollo/common/dto/ReleaseDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseHistoryController##findReleaseHistoriesByNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Lcom/ctrip/framework/apollo/common/dto/PageDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseHistoryController##findReleaseHistoryByPreviousReleaseIdAndOperation##(JILorg/springframework/data/domain/Pageable;)Lcom/ctrip/framework/apollo/common/dto/PageDTO;",
            "com/ctrip/framework/apollo/adminservice/controller/ReleaseHistoryController##findReleaseHistoryByReleaseIdAndOperation##(JILorg/springframework/data/domain/Pageable;)Lcom/ctrip/framework/apollo/common/dto/PageDTO;",
            "com/ctrip/framework/apollo/common/controller/ApolloInfoController##getApp##()Ljava/lang/String;",
            "com/ctrip/framework/apollo/common/controller/ApolloInfoController##getNet##()Ljava/lang/String;",
            "com/ctrip/framework/apollo/common/controller/ApolloInfoController##getServer##()Ljava/lang/String;",
            "com/ctrip/framework/apollo/common/controller/ApolloInfoController##getVersion##()Ljava/lang/String;",
            "com/ctrip/framework/apollo/configservice/controller/ConfigController##queryConfig##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;)Lcom/ctrip/framework/apollo/core/dto/ApolloConfig;",
            "com/ctrip/framework/apollo/configservice/controller/ConfigFileController##queryConfigAsJson##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/configservice/controller/ConfigFileController##queryConfigAsProperties##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/configservice/controller/NotificationController##pollNotification##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)Lorg/springframework/web/context/request/async/DeferredResult;",
            "com/ctrip/framework/apollo/configservice/controller/NotificationControllerV2##pollNotification##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/web/context/request/async/DeferredResult;",
            "com/ctrip/framework/apollo/metaservice/controller/ServiceController##getAdminService##()Ljava/util/List;",
            "com/ctrip/framework/apollo/metaservice/controller/ServiceController##getConfigService##(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/metaservice/controller/ServiceController##getMetaService##()Ljava/util/List;",
            "com/ctrip/framework/apollo/openapi/v1/controller/AppController##findApps##(Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/openapi/v1/controller/AppController##loadEnvClusterInfo##(Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ClusterController##createCluster##(Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/openapi/dto/OpenClusterDTO;Ljavax/servlet/http/HttpServletRequest;)Lcom/ctrip/framework/apollo/openapi/dto/OpenClusterDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ClusterController##loadCluster##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/openapi/dto/OpenClusterDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ItemController##createItem##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/openapi/dto/OpenItemDTO;Ljavax/servlet/http/HttpServletRequest;)Lcom/ctrip/framework/apollo/openapi/dto/OpenItemDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ItemController##deleteItem##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljavax/servlet/http/HttpServletRequest;)V",
            "com/ctrip/framework/apollo/openapi/v1/controller/ItemController##getItem##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/openapi/dto/OpenItemDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ItemController##updateItem##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/openapi/dto/OpenItemDTO;ZLjavax/servlet/http/HttpServletRequest;)V",
            "com/ctrip/framework/apollo/openapi/v1/controller/NamespaceBranchController##createBranch##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljavax/servlet/http/HttpServletRequest;)Lcom/ctrip/framework/apollo/openapi/dto/OpenNamespaceDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/NamespaceBranchController##deleteBranch##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljavax/servlet/http/HttpServletRequest;)V",
            "com/ctrip/framework/apollo/openapi/v1/controller/NamespaceBranchController##findBranch##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/openapi/dto/OpenNamespaceDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/NamespaceBranchController##getBranchGrayRules##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/openapi/dto/OpenGrayReleaseRuleDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/NamespaceBranchController##updateBranchRules##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/openapi/dto/OpenGrayReleaseRuleDTO;Ljava/lang/String;Ljavax/servlet/http/HttpServletRequest;)V",
            "com/ctrip/framework/apollo/openapi/v1/controller/NamespaceController##createNamespace##(Ljava/lang/String;Lcom/ctrip/framework/apollo/openapi/dto/OpenAppNamespaceDTO;Ljavax/servlet/http/HttpServletRequest;)Lcom/ctrip/framework/apollo/openapi/dto/OpenAppNamespaceDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/NamespaceController##findNamespaces##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/openapi/v1/controller/NamespaceController##getNamespaceLock##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/openapi/dto/OpenNamespaceLockDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/NamespaceController##loadNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/openapi/dto/OpenNamespaceDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ReleaseController##createGrayDelRelease##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/openapi/dto/NamespaceGrayDelReleaseDTO;Ljavax/servlet/http/HttpServletRequest;)Lcom/ctrip/framework/apollo/openapi/dto/OpenReleaseDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ReleaseController##createGrayRelease##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/openapi/dto/NamespaceReleaseDTO;Ljavax/servlet/http/HttpServletRequest;)Lcom/ctrip/framework/apollo/openapi/dto/OpenReleaseDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ReleaseController##createRelease##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/openapi/dto/NamespaceReleaseDTO;Ljavax/servlet/http/HttpServletRequest;)Lcom/ctrip/framework/apollo/openapi/dto/OpenReleaseDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ReleaseController##loadLatestActiveRelease##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/openapi/dto/OpenReleaseDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ReleaseController##merge##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/ctrip/framework/apollo/openapi/dto/NamespaceReleaseDTO;Ljavax/servlet/http/HttpServletRequest;)Lcom/ctrip/framework/apollo/openapi/dto/OpenReleaseDTO;",
            "com/ctrip/framework/apollo/openapi/v1/controller/ReleaseController##rollback##(Ljava/lang/String;JLjava/lang/String;Ljavax/servlet/http/HttpServletRequest;)V",
            "com/ctrip/framework/apollo/portal/controller/AccessKeyController##delete##(Ljava/lang/String;Ljava/lang/String;J)V",
            "com/ctrip/framework/apollo/portal/controller/AccessKeyController##disable##(Ljava/lang/String;Ljava/lang/String;J)V",
            "com/ctrip/framework/apollo/portal/controller/AccessKeyController##enable##(Ljava/lang/String;Ljava/lang/String;J)V",
            "com/ctrip/framework/apollo/portal/controller/AccessKeyController##findByAppId##(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/AccessKeyController##save##(Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/AccessKeyDTO;)Lcom/ctrip/framework/apollo/common/dto/AccessKeyDTO;",
            "com/ctrip/framework/apollo/portal/controller/AppController##create##(Lcom/ctrip/framework/apollo/portal/entity/model/AppModel;)Lcom/ctrip/framework/apollo/common/entity/App;",
            "com/ctrip/framework/apollo/portal/controller/AppController##create##(Ljava/lang/String;Lcom/ctrip/framework/apollo/common/entity/App;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/AppController##deleteApp##(Ljava/lang/String;)V",
            "com/ctrip/framework/apollo/portal/controller/AppController##findApps##(Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/AppController##findAppsByOwner##(Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/AppController##findMissEnvs##(Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/http/MultiResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/AppController##load##(Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/entity/App;",
            "com/ctrip/framework/apollo/portal/controller/AppController##nav##(Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/http/MultiResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/AppController##searchByAppIdOrAppName##(Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Lcom/ctrip/framework/apollo/common/dto/PageDTO;",
            "com/ctrip/framework/apollo/portal/controller/AppController##update##(Ljava/lang/String;Lcom/ctrip/framework/apollo/portal/entity/model/AppModel;)V",
            "com/ctrip/framework/apollo/portal/controller/ClusterController##createCluster##(Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/ClusterDTO;)Lcom/ctrip/framework/apollo/common/dto/ClusterDTO;",
            "com/ctrip/framework/apollo/portal/controller/ClusterController##deleteCluster##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/ClusterController##loadCluster##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/ClusterDTO;",
            "com/ctrip/framework/apollo/portal/controller/CommitController##find##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/ConfigsExportController##exportAll##(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;)V",
            "com/ctrip/framework/apollo/portal/controller/ConfigsExportController##exportItems##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljavax/servlet/http/HttpServletResponse;)V",
            "com/ctrip/framework/apollo/portal/controller/ConfigsImportController##importConfigFile##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/springframework/web/multipart/MultipartFile;)V",
            "com/ctrip/framework/apollo/portal/controller/ConsumerController##assignNamespaceRoleToConsumer##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/NamespaceDTO;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/ConsumerController##createConsumer##(Lcom/ctrip/framework/apollo/openapi/entity/Consumer;Ljava/util/Date;)Lcom/ctrip/framework/apollo/openapi/entity/ConsumerToken;",
            "com/ctrip/framework/apollo/portal/controller/ConsumerController##getConsumerTokenByAppId##(Ljava/lang/String;)Lcom/ctrip/framework/apollo/openapi/entity/ConsumerToken;",
            "com/ctrip/framework/apollo/portal/controller/EnvController##envs##()Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/FavoriteController##addFavorite##(Lcom/ctrip/framework/apollo/portal/entity/po/Favorite;)Lcom/ctrip/framework/apollo/portal/entity/po/Favorite;",
            "com/ctrip/framework/apollo/portal/controller/FavoriteController##deleteFavorite##(J)V",
            "com/ctrip/framework/apollo/portal/controller/FavoriteController##findFavorites##(Ljava/lang/String;Ljava/lang/String;Lorg/springframework/data/domain/Pageable;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/FavoriteController##toTop##(J)V",
            "com/ctrip/framework/apollo/portal/controller/InstanceController##getByNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Lcom/ctrip/framework/apollo/common/dto/PageDTO;",
            "com/ctrip/framework/apollo/portal/controller/InstanceController##getByRelease##(Ljava/lang/String;JII)Lcom/ctrip/framework/apollo/common/dto/PageDTO;",
            "com/ctrip/framework/apollo/portal/controller/InstanceController##getByReleasesNotIn##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/InstanceController##getInstanceCountByNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/ItemController##createItem##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/ItemDTO;)Lcom/ctrip/framework/apollo/common/dto/ItemDTO;",
            "com/ctrip/framework/apollo/portal/controller/ItemController##deleteItem##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V",
            "com/ctrip/framework/apollo/portal/controller/ItemController##diff##(Lcom/ctrip/framework/apollo/portal/entity/model/NamespaceSyncModel;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/ItemController##findBranchItems##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/ItemController##findItems##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/ItemController##modifyItemsByText##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/portal/entity/model/NamespaceTextModel;)V",
            "com/ctrip/framework/apollo/portal/controller/ItemController##revokeItems##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
            "com/ctrip/framework/apollo/portal/controller/ItemController##syntaxCheckText##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/portal/entity/model/NamespaceTextModel;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/ItemController##update##(Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/portal/entity/model/NamespaceSyncModel;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/ItemController##updateItem##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/ItemDTO;)V",
            "com/ctrip/framework/apollo/portal/controller/NamespaceBranchController##createBranch##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/NamespaceDTO;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceBranchController##deleteBranch##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
            "com/ctrip/framework/apollo/portal/controller/NamespaceBranchController##findBranch##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/portal/entity/bo/NamespaceBO;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceBranchController##getBranchGrayRules##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/GrayReleaseRuleDTO;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceBranchController##merge##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/ctrip/framework/apollo/portal/entity/model/NamespaceReleaseModel;)Lcom/ctrip/framework/apollo/common/dto/ReleaseDTO;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceBranchController##updateBranchRules##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/common/dto/GrayReleaseRuleDTO;)V",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##createAppNamespace##(Ljava/lang/String;ZLcom/ctrip/framework/apollo/common/entity/AppNamespace;)Lcom/ctrip/framework/apollo/common/entity/AppNamespace;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##createMissingNamespaces##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##createNamespace##(Ljava/lang/String;Ljava/util/List;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##deleteAppNamespace##(Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##deleteNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##findAppNamespace##(Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/AppNamespaceDTO;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##findMissingNamespaces##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/http/MultiResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##findNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/portal/entity/bo/NamespaceBO;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##findNamespaces##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##findPublicAppNamespaces##()Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##findPublicNamespaceForAssociatedNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/portal/entity/bo/NamespaceBO;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##getNamespacesPublishInfo##(Ljava/lang/String;)Ljava/util/Map;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceController##getPublicAppNamespaceAllNamespaces##(Ljava/lang/String;Ljava/lang/String;II)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceLockController##getNamespaceLock##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/common/dto/NamespaceLockDTO;",
            "com/ctrip/framework/apollo/portal/controller/NamespaceLockController##getNamespaceLockInfo##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/portal/entity/vo/LockInfo;",
            "com/ctrip/framework/apollo/portal/controller/OrganizationController##loadOrganization##()Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/PageSettingController##getPageSetting##()Lcom/ctrip/framework/apollo/portal/entity/vo/PageSetting;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##addCreateApplicationRoleToUser##(Ljava/util/List;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##addManageAppMasterRoleToUser##(Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##assignAppRoleToUser##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##assignNamespaceEnvRoleToUser##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##assignNamespaceRoleToUser##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##deleteCreateApplicationRoleFromUser##(Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##forbidManageAppMaster##(Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##getAppRoles##(Ljava/lang/String;)Lcom/ctrip/framework/apollo/portal/entity/vo/AppRolesAssignedUsers;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##getCreateApplicationRoleUsers##()Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##getNamespaceEnvRoles##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/portal/entity/vo/NamespaceEnvRolesAssignedUsers;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##getNamespaceRoles##(Ljava/lang/String;Ljava/lang/String;)Lcom/ctrip/framework/apollo/portal/entity/vo/NamespaceRolesAssignedUsers;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##hasCreateApplicationPermission##(Ljava/lang/String;)Lcom/google/gson/JsonObject;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##hasPermission##(Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##hasPermission##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##hasPermission##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##hasRootPermission##()Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##initAppPermission##(Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##isManageAppMasterPermissionEnabled##()Lcom/google/gson/JsonObject;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##removeAppRoleFromUser##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##removeNamespaceEnvRoleFromUser##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PermissionController##removeNamespaceRoleFromUser##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/springframework/http/ResponseEntity;",
            "com/ctrip/framework/apollo/portal/controller/PrefixPathController##getPrefixPath##()Ljava/lang/String;",
            "com/ctrip/framework/apollo/portal/controller/ReleaseController##compareRelease##(Ljava/lang/String;JJ)Lcom/ctrip/framework/apollo/portal/entity/vo/ReleaseCompareResult;",
            "com/ctrip/framework/apollo/portal/controller/ReleaseController##createGrayRelease##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/portal/entity/model/NamespaceReleaseModel;)Lcom/ctrip/framework/apollo/common/dto/ReleaseDTO;",
            "com/ctrip/framework/apollo/portal/controller/ReleaseController##createRelease##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ctrip/framework/apollo/portal/entity/model/NamespaceReleaseModel;)Lcom/ctrip/framework/apollo/common/dto/ReleaseDTO;",
            "com/ctrip/framework/apollo/portal/controller/ReleaseController##findActiveReleases##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/ReleaseController##findAllReleases##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/ReleaseController##get##(Ljava/lang/String;J)Lcom/ctrip/framework/apollo/common/dto/ReleaseDTO;",
            "com/ctrip/framework/apollo/portal/controller/ReleaseController##rollback##(Ljava/lang/String;JJ)V",
            "com/ctrip/framework/apollo/portal/controller/ReleaseHistoryController##findReleaseHistoriesByNamespace##(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)Ljava/util/List;",
            "com/ctrip/framework/apollo/portal/controller/ServerConfigController##createOrUpdate##(Lcom/ctrip/framework/apollo/portal/entity/po/ServerConfig;)Lcom/ctrip/framework/apollo/portal/entity/po/ServerConfig;",
            "com/ctrip/framework/apollo/portal/controller/ServerConfigController##loadServerConfig##(Ljava/lang/String;)Lcom/ctrip/framework/apollo/portal/entity/po/ServerConfig;",
            "com/ctrip/framework/apollo/portal/controller/SignInController##login##(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;",
            "com/ctrip/framework/apollo/portal/controller/SsoHeartbeatController##heartbeat##(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;)V",
            "com/ctrip/framework/apollo/portal/controller/SystemInfoController##checkHealth##(Ljava/lang/String;)Lorg/springframework/boot/actuate/health/Health;",
            "com/ctrip/framework/apollo/portal/controller/SystemInfoController##getSystemInfo##()Lcom/ctrip/framework/apollo/portal/entity/vo/SystemInfo;",
            "com/ctrip/framework/apollo/portal/controller/UserInfoController##createOrUpdateUser##(Lcom/ctrip/framework/apollo/portal/entity/po/UserPO;)V",
            "com/ctrip/framework/apollo/portal/controller/UserInfoController##getCurrentUserName##()Lcom/ctrip/framework/apollo/portal/entity/bo/UserInfo;",
            "com/ctrip/framework/apollo/portal/controller/UserInfoController##getUserByUserId##(Ljava/lang/String;)Lcom/ctrip/framework/apollo/portal/entity/bo/UserInfo;",
            "com/ctrip/framework/apollo/portal/controller/UserInfoController##logout##(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;)V",
            "com/ctrip/framework/apollo/portal/controller/UserInfoController##searchUsersByKeyword##(Ljava/lang/String;II)Ljava/util/List;",

            // piggy metrics
            "com/piggymetrics/statistics/client/ExchangeRatesClient##getRates##(Lcom/piggymetrics/statistics/domain/Currency;)Lcom/piggymetrics/statistics/domain/ExchangeRatesContainer;",
            "com/piggymetrics/statistics/controller/StatisticsController##getCurrentAccountStatistics##(Ljava/security/Principal;)Ljava/util/List;",
            "com/piggymetrics/statistics/controller/StatisticsController##getStatisticsByAccountName##(Ljava/lang/String;)Ljava/util/List;",
            "com/piggymetrics/statistics/controller/StatisticsController##saveAccountStatistics##(Ljava/lang/String;Lcom/piggymetrics/statistics/domain/Account;)V",
            "com/piggymetrics/account/controller/AccountController##getAccountByName##(Ljava/lang/String;)Lcom/piggymetrics/account/domain/Account;",
            "com/piggymetrics/account/controller/AccountController##getCurrentAccount##(Ljava/security/Principal;)Lcom/piggymetrics/account/domain/Account;",
            "com/piggymetrics/account/controller/AccountController##saveCurrentAccount##(Ljava/security/Principal;Lcom/piggymetrics/account/domain/Account;)V",
            "com/piggymetrics/account/controller/AccountController##createNewAccount##(Lcom/piggymetrics/account/domain/User;)Lcom/piggymetrics/account/domain/Account;",
            "com/piggymetrics/account/client/StatisticsServiceClient##updateStatistics##(Ljava/lang/String;Lcom/piggymetrics/account/domain/Account;)V",
            "com/piggymetrics/account/client/AuthServiceClient##createUser##(Lcom/piggymetrics/account/domain/User;)V",
            "com/piggymetrics/notification/controller/RecipientController##getCurrentNotificationsSettings##(Ljava/security/Principal;)Ljava/lang/Object;",
            "com/piggymetrics/notification/controller/RecipientController##saveCurrentNotificationsSettings##(Ljava/security/Principal;Lcom/piggymetrics/notification/domain/Recipient;)Ljava/lang/Object;",
            "com/piggymetrics/notification/client/AccountServiceClient##getAccount##(Ljava/lang/String;)Ljava/lang/String;",
            "com/piggymetrics/auth/controller/UserController##getUser##(Ljava/security/Principal;)Ljava/security/Principal;",
            "com/piggymetrics/auth/controller/UserController##createUser##(Lcom/piggymetrics/auth/domain/User;)V",

            // zlt
            "com/central/oauth/controller/ClientController##list##(Ljava/util/Map;)Lcom/central/common/model/PageResult;",
            "com/central/oauth/controller/ClientController##get##(Ljava/lang/Long;)Lcom/central/oauth/model/Client;",
            "com/central/oauth/controller/ClientController##allClient##()Lcom/central/common/model/Result;",
            "com/central/oauth/controller/ClientController##delete##(Ljava/lang/Long;)V",
            "com/central/oauth/controller/ClientController##saveOrUpdate##(Lcom/central/oauth/dto/ClientDto;)Lcom/central/common/model/Result;",
            "com/central/oauth/controller/TokensController##list##(Ljava/util/Map;Ljava/lang/String;)Lcom/central/common/model/PageResult;",
            "com/central/oauth/controller/TokensController##key##(Ljavax/servlet/http/HttpServletRequest;)Lcom/central/common/model/Result;",
            "com/central/oauth/controller/ValidateCodeController##createCode##(Ljava/lang/String;Ljavax/servlet/http/HttpServletResponse;)V",
            "com/central/oauth/controller/ValidateCodeController##createCode##(Ljava/lang/String;)Lcom/central/common/model/Result;",
            "com/central/common/feign/UserService##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/common/feign/UserService##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/search/client/feign/SearchService##strQuery##(Ljava/lang/String;Lcom/central/search/model/SearchDto;)Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysMenuController##delete##(Ljava/lang/Long;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysMenuController##findMenusByRoleId##(Ljava/lang/Long;)Ljava/util/List;",
            "com/central/user/controller/SysMenuController##findMenuByRoles##(Ljava/lang/String;)Ljava/util/List;",
            "com/central/user/controller/SysMenuController##setMenuToRole##(Lcom/central/common/model/SysMenu;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysMenuController##findAlls##()Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysMenuController##findOnes##()Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysMenuController##saveOrUpdate##(Lcom/central/common/model/SysMenu;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysMenuController##findMyMenu##(Lcom/central/common/model/SysUser;)Ljava/util/List;",
            "com/central/user/controller/SysRoleController##findRoles##(Ljava/util/Map;)Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysRoleController##findAll##()Lcom/central/common/model/Result;",
            "com/central/user/controller/SysRoleController##saveOrUpdate##(Lcom/central/common/model/SysRole;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysRoleController##deleteRole##(Ljava/lang/Long;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##getLoginAppUser##(Lcom/central/common/model/SysUser;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/user/controller/SysUserController##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##findUserById##(Ljava/lang/Long;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##updateSysUser##(Lcom/central/common/model/SysUser;)V",
            "com/central/user/controller/SysUserController##setRoleToUser##(Ljava/lang/Long;Ljava/util/Set;)V",
            "com/central/user/controller/SysUserController##findRolesByUserId##(Ljava/lang/Long;)Ljava/util/List;",
            "com/central/user/controller/SysUserController##findUsers##(Ljava/util/Map;)Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysUserController##updateEnabled##(Ljava/util/Map;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##resetPassword##(Ljava/lang/Long;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##resetPassword##(Lcom/central/common/model/SysUser;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##delete##(Ljava/lang/Long;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##saveOrUpdate##(Lcom/central/common/model/SysUser;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##saveOrUpdate1##(Lcom/central/common/model/SysUser;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##saveOrUpdate2##(Lcom/central/common/model/SysUser;)Ljava/lang/String;",
            "com/central/user/controller/SysUserController##saveOrUpdate2_1##(Lcom/central/common/model/SysUser;)Ljava/lang/String;",
            "com/central/user/controller/SysUserController##saveOrUpdate3##(Lcom/central/common/model/SysUser;)Ljava/lang/String;",
            "com/central/user/controller/SysUserController##saveOrUpdate3_1##(Lcom/central/common/model/SysUser;)Ljava/lang/String;",
            "com/central/user/controller/SysUserController##saveOrUpdate4##(Lcom/central/common/model/SysUser;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##saveOrUpdate4_1##(Lcom/central/common/model/SysUser;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##saveOrUpdate5##(Ljava/lang/String;)Ljava/lang/String;",
            "com/central/user/controller/SysUserController##saveOrUpdate6##(Ljava/lang/String;)Ljava/lang/String;",
            "com/central/user/controller/SysUserController##getPersonAge1##(Lcom/central/common/model/Person;)I",
            "com/central/user/controller/SysUserController##getPersonAge2##(Lcom/central/common/model/Person;)I",
            "com/central/user/controller/SysUserController##getPersonName1##(Lcom/central/common/model/Person;)Ljava/lang/String;",
            "com/central/user/controller/SysUserController##getPersonName2##(Lcom/central/common/model/Person;)Ljava/lang/String;",
//            "com/central/user/controller/SysUserController##add##(II)I",
            "com/central/user/controller/SysUserController##exportUser##(Ljava/util/Map;Ljavax/servlet/http/HttpServletResponse;)V",
            "com/central/user/controller/SysUserController##importExcl##(Lorg/springframework/web/multipart/MultipartFile;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##search##(Lcom/central/search/model/SearchDto;)Lcom/central/common/model/PageResult;",
            "com/central/common/feign/UserService##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/common/feign/UserService##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/search/client/feign/AggregationService##requestStatAgg##(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;",
            "com/central/gateway/feign/MenuService##findByRoleCodes##(Ljava/lang/String;)Ljava/util/List;",
            "com/central/common/feign/UserService##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/common/feign/UserService##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/gateway/swagger/SwaggerHandler##securityConfiguration##()Lreactor/core/publisher/Mono;",
            "com/central/gateway/swagger/SwaggerHandler##uiConfiguration##()Lreactor/core/publisher/Mono;",
            "com/central/gateway/swagger/SwaggerHandler##swaggerResources##()Lreactor/core/publisher/Mono;",
            "com/central/gateway/feign/MenuService##findByRoleCodes##(Ljava/lang/String;)Ljava/util/List;",
            "com/central/common/feign/UserService##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/common/feign/UserService##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/search/client/feign/SearchService##strQuery##(Ljava/lang/String;Lcom/central/search/model/SearchDto;)Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysMenuController##delete##(Ljava/lang/Long;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysMenuController##findMenusByRoleId##(Ljava/lang/Long;)Ljava/util/List;",
            "com/central/user/controller/SysMenuController##findMenuByRoles##(Ljava/lang/String;)Ljava/util/List;",
            "com/central/user/controller/SysMenuController##setMenuToRole##(Lcom/central/common/model/SysMenu;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysMenuController##findAlls##()Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysMenuController##findOnes##()Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysMenuController##saveOrUpdate##(Lcom/central/common/model/SysMenu;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysMenuController##findMyMenu##(Lcom/central/common/model/SysUser;)Ljava/util/List;",
            "com/central/user/controller/SysRoleController##findRoles##(Ljava/util/Map;)Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysRoleController##findAll##()Lcom/central/common/model/Result;",
            "com/central/user/controller/SysRoleController##saveOrUpdate##(Lcom/central/common/model/SysRole;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysRoleController##deleteRole##(Ljava/lang/Long;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##getLoginAppUser##(Lcom/central/common/model/SysUser;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/user/controller/SysUserController##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##findUserById##(Ljava/lang/Long;)Lcom/central/common/model/SysUser;",
            "com/central/user/controller/SysUserController##updateSysUser##(Lcom/central/common/model/SysUser;)V",
            "com/central/user/controller/SysUserController##setRoleToUser##(Ljava/lang/Long;Ljava/util/Set;)V",
            "com/central/user/controller/SysUserController##findRolesByUserId##(Ljava/lang/Long;)Ljava/util/List;",
            "com/central/user/controller/SysUserController##findUsers##(Ljava/util/Map;)Lcom/central/common/model/PageResult;",
            "com/central/user/controller/SysUserController##updateEnabled##(Ljava/util/Map;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##resetPassword##(Ljava/lang/Long;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##resetPassword##(Lcom/central/common/model/SysUser;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##delete##(Ljava/lang/Long;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##saveOrUpdate##(Lcom/central/common/model/SysUser;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##exportUser##(Ljava/util/Map;Ljavax/servlet/http/HttpServletResponse;)V",
            "com/central/user/controller/SysUserController##importExcl##(Lorg/springframework/web/multipart/MultipartFile;)Lcom/central/common/model/Result;",
            "com/central/user/controller/SysUserController##search##(Lcom/central/search/model/SearchDto;)Lcom/central/common/model/PageResult;",
            "com/central/common/feign/UserService##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/common/feign/UserService##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/search/client/feign/AggregationService##requestStatAgg##(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;",
            "com/central/gateway/feign/MenuService##findByRoleCodes##(Ljava/lang/String;)Ljava/util/List;",
            "com/central/common/feign/UserService##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/common/feign/UserService##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/gateway/swagger/SwaggerHandler##securityConfiguration##()Lreactor/core/publisher/Mono;",
            "com/central/gateway/swagger/SwaggerHandler##uiConfiguration##()Lreactor/core/publisher/Mono;",
            "com/central/gateway/swagger/SwaggerHandler##swaggerResources##()Lreactor/core/publisher/Mono;",
            "com/central/gateway/feign/MenuService##findByRoleCodes##(Ljava/lang/String;)Ljava/util/List;",
            "com/central/common/feign/UserService##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/common/feign/UserService##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/gateway/swagger/SwaggerHandler##securityConfiguration##()Lreactor/core/publisher/Mono;",
            "com/central/gateway/swagger/SwaggerHandler##uiConfiguration##()Lreactor/core/publisher/Mono;",
            "com/central/gateway/swagger/SwaggerHandler##swaggerResources##()Lreactor/core/publisher/Mono;",
            "com/central/gateway/feign/MenuService##findByRoleCodes##(Ljava/lang/String;)Ljava/util/List;",
            "com/central/common/feign/UserService##selectByUsername##(Ljava/lang/String;)Lcom/central/common/model/SysUser;",
            "com/central/common/feign/UserService##findByUsername##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByMobile##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;",
            "com/central/common/feign/UserService##findByOpenId##(Ljava/lang/String;)Lcom/central/common/model/LoginAppUser;"
            );

    public static final Set<String> interfaceClasses = interfaceMethods
            .stream()
            .map(x -> x.substring(0, x.indexOf("##")))
            .collect(Collectors.toSet());

    public static final Set<String> phosInterfaces = interfaceMethods
            .stream()
            .map(x -> x.substring(0, x.lastIndexOf("##")) + "$$PHOSPHORTAGGED")
            .collect(Collectors.toSet());

    public static boolean isTargetClass(String slashClassName){
        return interfaceClasses.contains(slashClassName) || isDaoClass(slashClassName);
    }

    public static boolean isTargetMethod(String className, String methodName, String desc){
        String key = className + "##" + methodName + "##" + desc;
        if (interfaceMethods.contains(key)){
            return true;
        }
        return false;
    }

    public static final Set<String> daoClasses = Sets.newHashSet(
            "com/central/user/service/impl/SysMenuServiceImpl",
            "com/central/user/service/impl/SysRoleMenuServiceImpl",
            "com/central/user/service/impl/SysRoleServiceImpl",
            "com/central/user/service/impl/SysRoleUserServiceImpl",
            "com/central/user/service/impl/SysUserServiceImpl",
            "com/central/user/service/impl/SysMenuService",
            "com/central/user/service/impl/SysRoleMenuService",
            "com/central/user/service/impl/SysRoleService",
            "com/central/user/service/impl/SysRoleUserService",
            "com/central/user/service/impl/SysUserService",

            "works/weave/socks/cart/cart/CartDAO",
            "works/weave/socks/cart/cart/CartDAO$Fake",
            "works/weave/socks/cart/item/ItemDAO",
            "works/weave/socks/cart/item/ItemDAO$Fake",

            "com/piggymetrics/account/repository/AccountRepository",
            "com/piggymetrics/auth/repository/UserRepository",
            "com/piggymetrics/notification/repository/RecipientRepositor",

            "com/ctrip/framework/apollo/portal/service/NamespaceService",
            "com/ctrip/framework/apollo/portal/service/AccessKeyService",
            "com/ctrip/framework/apollo/portal/service/AppNamespaceService",
            "com/ctrip/framework/apollo/portal/service/AppService",
            "com/ctrip/framework/apollo/portal/service/ClusterService"
    );

    public static boolean isDaoClass(String slashClassName){
        return daoClasses.contains(slashClassName);
    }

    public static boolean isTargetPhosMethod(String className, String methodName){
        String key = className + "##" + methodName;
        if (phosInterfaces.contains(key)){
            return true;
        }
        return false;
    }

    public static synchronized String version() {
        String version = System.getProperty("toolagent.version");
        if (version == null) {
            version = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            System.setProperty("toolagent.version", version);
        }
        return version;
    }

    public static synchronized String env() {
        String env = System.getProperty("toolagent.env");
        if (env == null || env.isEmpty()) {
            env = "docker";
        }
        return env;
    }

    public static String workingDirectory() {
        switch (env()){
            case "docker":
                return "/toolAgent/";
            case "local":
                return System.getProperty("user.home") + "/AgentLogs/toolAgent/" + version() + "/";
            default:
                return "/toolAgent/";
        }
    }
}
