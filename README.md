OuterRecyclerView 안에 InnerRecyclerView가 포함되는 구조로 작성해야하는 경우 어떻게 해야할까?

### 뷰 계층 구조 
<pre>
ConstraintLayout
  L RecyclerView
      L TextView
      L RecyclerView
          L TextView
</pre>

### 아이템 뷰 레이아웃 설정
item_outer.xml - OuterRecyclerView의 아이템 레이아웃
```xml
<android.support.constraint.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    
    <android.support.v7.widget.RecyclerView
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        ... />
</android.support.constraint.ConstraintLayout>
```

item_inner.xml - InnerRecyclerView의 아이템 레이아웃
```xml
<android.support.constraint.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">
    
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />
</android.support.constraint.ConstraintLayout>
```

### 결과
OuterRecyclerView 아이템 뷰의 높이가 wrap_content이면 InnerRecyclerView가 갖을 수 있는 높이까지 갖게 된다.
InnerRecyclerView의 onBindViewHolder() 메소드에 로그를 찍어보면 InnerRecyclerView의 모든 아이템이 한번에 그려지는 것을 확인할 수 있다.     