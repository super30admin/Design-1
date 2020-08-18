MinStack = () ->
  Object.assign(Object.create(MinStack::),
    st: Array(16),
    min: null,
    topIndex: -1,
  )

MinStack::push = (x) ->
  @st[++@topIndex] = x
  @min = x if @min == null or @min > x
  null

MinStack::pop = () ->
  if @st[@topIndex] == @min
    @min = null
    for ti in [@topIndex-1..0]
      if @min == null or @min > @st[ti]
        @min = @st[ti]
  @topIndex--
  null

MinStack::top = () ->
  @st[@topIndex]

MinStack::getMin = () ->
  @min
  # should implement a min heap but just for correctness, brute force!
